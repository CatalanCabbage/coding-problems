//https://adventofcode.com/2021/day/1
//partOne: Given a list of depths, count the number of times a depth measurement increases from the previous measurement
//partTwo: Given a list of depths, count the number of times a sliding window of size 3 increases from the previous measurement
package main

import (
	"fmt"
	"math"
	"strconv"
)

func runDay1() {
	inputStr := getSliceFromFile("day_1.txt")
	//Convert strings to int elements
	var input []int
	for _, str := range inputStr {
		num, err := strconv.Atoi(str)
		if err != nil {
			fmt.Println(err)
			break
		}
		input = append(input, num)
	}

	partOne(input)
	partTwo(input)
}

func partOne(input []int) {
	depthIncreases := 0
	prevNum := math.MaxInt //So that first entry isn't counted

	for _, currentNum := range input {
		if currentNum > prevNum {
			depthIncreases += 1
		}
		prevNum = currentNum
	}

	fmt.Println("Depth increases: ", depthIncreases)
}

func partTwo(input []int) {
	depthIncreases := 0
	for i := 2; i < len(input)-1; i++ {
		leftmostElement := input[i-2]
		nextElement := input[i+1]
		if nextElement > leftmostElement {
			depthIncreases++
		}
	}
	fmt.Println("Window of 3 depth increases: ", depthIncreases)
}
