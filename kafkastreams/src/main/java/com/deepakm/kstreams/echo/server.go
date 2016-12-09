package main

import (
	"log"
	"net/http"
	"io/ioutil"
	"fmt"
)

type test_struct struct {
	Test string
}

func test(rw http.ResponseWriter, req *http.Request) {
	body, err := ioutil.ReadAll(req.Body)
	if err != nil {
		fmt.Println("---------------error---------")
	}
	log.Println(string(body))
}

func main() {
	http.HandleFunc("/bookinglog", test)
	log.Fatal(http.ListenAndServe(":8080", nil))
}