//Go can have only 1 main() in a package.
//day_0 calls other methods and contains utils
package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	runDay1()
	runDay2()
}

func getSliceFromFile(fileName string) []string {
	var input []string

	file, err := os.Open(fileName)
	if err != nil {
		fmt.Println(err)
	}
	defer file.Close()

	scanner := bufio.NewScanner(file)
	for scanner.Scan() {
		num := scanner.Text()
		input = append(input, num)
	}
	return input
}
