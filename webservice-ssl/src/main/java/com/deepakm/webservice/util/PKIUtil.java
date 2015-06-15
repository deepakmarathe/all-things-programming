package com.deepakm.webservice.util;

import org.bouncycastle.jce.X509Principal;
import org.bouncycastle.x509.X509V3CertificateGenerator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Date;

public class PKIUtil {

    private PKIUtil() {

    }

    public static void generateSelfSignedCertificate(
            String domainName, String pathToKeyStore, String pathToCertificate, String keyStorePassword)
            throws PKIException {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(1024);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            X509V3CertificateGenerator v3CertGen = new X509V3CertificateGenerator();

            v3CertGen.setSerialNumber(BigInteger.valueOf(new SecureRandom().nextInt(1000000000)));
            v3CertGen.setIssuerDN(new X509Principal("CN=" + domainName + ", OU=None, O=None L=None, C=None"));
            v3CertGen.setNotBefore(new Date(System.currentTimeMillis() - 1000L * 60 * 60 * 24 * 30));
            v3CertGen.setNotAfter(new Date(System.currentTimeMillis() + (1000L * 60 * 60 * 24 * 365 * 10)));
            v3CertGen.setSubjectDN(new X509Principal("CN=" + domainName + ", OU=None, O=None L=None, C=None"));

            v3CertGen.setPublicKey(keyPair.getPublic());
            v3CertGen.setSignatureAlgorithm("MD5WITHRSA");

            X509Certificate publicKeyCertificate = v3CertGen.generate(keyPair.getPrivate());

            FileOutputStream fos = new FileOutputStream(pathToCertificate);
            fos.write(publicKeyCertificate.getEncoded());
            fos.close();

            KeyStore privateKS = KeyStore.getInstance("JKS");
            privateKS.load(null /* fis */, keyStorePassword.toCharArray());

            privateKS.setKeyEntry(domainName, keyPair.getPrivate(),
                    keyStorePassword.toCharArray(),
                    new java.security.cert.Certificate[]{publicKeyCertificate});

            privateKS.store(new FileOutputStream(pathToKeyStore), keyStorePassword.toCharArray());
        } catch (NoSuchAlgorithmException | SignatureException | InvalidKeyException | IOException |
                CertificateException | KeyStoreException ex) {
            throw new PKIException(ex.getMessage(), ex);
        }
    }

    public static void importCertToKeystore(String certificatePath, String keyStorePath, String keyStorePassword)
            throws PKIException {
        try {
            KeyStore ks = KeyStore.getInstance("JKS");
            ks.load(null, null);
            FileInputStream fis = new FileInputStream(certificatePath);
            BufferedInputStream bis = new BufferedInputStream(fis);
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            java.security.cert.Certificate cert = null;
            while (bis.available() > 0) {
                cert = cf.generateCertificate(bis);
                ks.setCertificateEntry("SGCert", cert);
            }
            ks.setCertificateEntry("SGCert", cert);
            ks.store(new FileOutputStream(keyStorePath), keyStorePassword.toCharArray());
        } catch (CertificateException | NoSuchAlgorithmException | IOException | KeyStoreException e) {
            throw new PKIException(e.getMessage(), e);
        }
    }

}

