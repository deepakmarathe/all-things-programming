package com.deepakm.vertica.udx.scalar;

import com.vertica.sdk.*;

/**
 * Created by dmarathe on 12/29/15.
 */
public class DeleteVowelFactory extends ScalarFunctionFactory {

    @Override
    public ScalarFunction createScalarFunction(ServerInterface serverInterface) {
        return new DeleteVowels();
    }

    @Override
    public void getPrototype(ServerInterface serverInterface, ColumnTypes argTypes, ColumnTypes returnTypes) {
        argTypes.addVarchar();
        returnTypes.addVarchar();
    }

    @Override
    public void getReturnType(ServerInterface srvInterface, SizedColumnTypes argTypes, SizedColumnTypes returnType) throws UdfException {
        returnType.addVarchar(argTypes.getColumnType(0).getStringLength(), "RemovedVowels : ");
    }

    public class DeleteVowels extends ScalarFunction {
        @Override
        public void processBlock(ServerInterface serverInterface, BlockReader blockReader, BlockWriter blockWriter) throws UdfException, DestroyInvocation {
            VowelRemover vowelRemover = new VowelRemover();
            do {
                String str = blockReader.getString(0);
                blockWriter.setString(vowelRemover.removeVowels(str));
                blockWriter.next();
            } while (blockReader.next());
        }
    }
}
