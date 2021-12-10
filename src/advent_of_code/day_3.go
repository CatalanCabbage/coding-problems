//Input consists of a list of binary numbers.
//partOne: generate two new binary numbers (called the gamma rate and the epsilon rate) and find the product
//gamma rate can be determined by finding the most common bit in the corresponding position of all numbers in the diagnostic report
//epsilon rate is the least common bit in each position.
//
//partTwo:  select two new binary numbers (called the oxygen rating and the CO2 rating) and find the product
//oxygen rating: determine the most common value in that position across all inputs, keep only those inputs
//do this for all positions till only 1 is left
//CO2 rating: similar, but least common value.
//
//https://adventofcode.com/2021/day/3
package main

import (
	"fmt"
	"strconv"
	"strings"
)

func runDay3() {
	inputStr := getSliceFromFile("day_3.txt")

	fmt.Println("----------------Day 3----------------")
	day3v1(inputStr)
	day3v2(inputStr)
	fmt.Println("-------------------------------------")
}

func day3v1(inputStr []string) {
	var gammaInt [12]int
	gamma := ""
	epsilon := ""

	//Which appears more, '1's or '0's?
	//If it's '0', number--. If it's '1', number++.
	//So in the end, if number is negative, it means there were more 0s and vice versa.
	for _, num := range inputStr {
		for i, digitChar := range num {
			if digitChar == '0' {
				gammaInt[i] -= 1
			} else {
				gammaInt[i] += 1
			}
		}
	}

	for _, digit := range gammaInt {
		if digit > 0 {
			gamma = strings.Join([]string{gamma, "1"}, "")
			epsilon = strings.Join([]string{epsilon, "0"}, "")
		} else {
			gamma = strings.Join([]string{gamma, "0"}, "")
			epsilon = strings.Join([]string{epsilon, "1"}, "")
		}
	}

	gammaDecimal, _ := strconv.ParseInt(gamma, 2, 64)
	epsilonDecimal, _ := strconv.ParseInt(epsilon, 2, 64)

	fmt.Println("Gamma x Epsilon = ", gammaDecimal*epsilonDecimal)
}

func day3v2(inputStr []string) {
	oxygenRating := findOxygenRating(inputStr)
	co2Rating := findCo2Rating(inputStr)

	fmt.Println("Oxygen rating x CO2 rating = ", oxygenRating*co2Rating)
}

func findOxygenRating(inputStr []string) int {
	currentInput := inputStr

	for currentDigit := 0; currentDigit < 12; currentDigit++ {
		var stack0 []string
		var stack1 []string
		//Put all input binary numbers into buckets
		for _, binaryNum := range currentInput {
			if binaryNum[currentDigit] == '0' {
				stack0 = append(stack0, binaryNum)
			} else {
				stack1 = append(stack1, binaryNum)
			}
		}

		//After putting in buckets, take the bucket with most numbers as new input. When equal, take "1"s
		if len(stack1) >= len(stack0) {
			currentInput = stack1
		} else {
			currentInput = stack0
		}
		//But if that bucket has only 1 number, our answer has been found
		if len(currentInput) == 1 {
			oxygenRating, _ := strconv.ParseInt(currentInput[0], 2, 64)
			return int(oxygenRating)
		}
	}
	return -1
}

func findCo2Rating(inputStr []string) int {
	currentInput := inputStr

	for currentDigit := 0; currentDigit < 12; currentDigit++ {
		var stack0 []string
		var stack1 []string
		//Put all input binary numbers into buckets
		for _, binaryNum := range currentInput {
			if binaryNum[currentDigit] == '0' {
				stack0 = append(stack0, binaryNum)
			} else {
				stack1 = append(stack1, binaryNum)
			}
		}

		//After putting in buckets, take the bucket with least numbers as new input. When equal, take "0"s
		if len(stack0) <= len(stack1) {
			currentInput = stack0
		} else {
			currentInput = stack1
		}
		//But if that bucket has only 1 number, our answer has been found
		if len(currentInput) == 1 {
			co2Rating, _ := strconv.ParseInt(currentInput[0], 2, 64)
			return int(co2Rating)
		}
	}
	return -1
}
