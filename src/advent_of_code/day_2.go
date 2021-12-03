/**
https://adventofcode.com/2021/day/2
Given a list of commands like forward 1, down 2, or up 3:
dayOne: Find product of final horizontal position and depth
dayTwo: "down" and "up" increases/decreases aim. "forward" increases horizontal position by x, and depth by aim*x. Find product.
*/
package main

import (
	"fmt"
	"strconv"
	"strings"
)

type movement struct {
	direction string
	value     int
}

func runDay2() {
	fmt.Println("----------------Day 2----------------")
	inputStr := getSliceFromFile("day_2.txt")
	var input []movement
	for _, str := range inputStr {
		components := strings.Fields(str)
		intValue, _ := strconv.Atoi(components[1])

		tempMovement := movement{components[0], intValue}
		input = append(input, tempMovement)

	}
	day2v1(input)
	day2v2(input)

	fmt.Println("-------------------------------------")
}

func day2v1(input []movement) {
	depth := 0
	horizontalPosition := 0

	for _, movement := range input {
		direction := movement.direction
		value := movement.value
		switch direction {
		case "forward":
			horizontalPosition += value
		case "down":
			depth += value
		case "up":
			depth -= value
		}
	}

	fmt.Println("Product of final depth and horizontal position: ", depth*horizontalPosition)
}

func day2v2(input []movement) {
	depth := 0
	aim := 0
	horizontalPosition := 0

	for _, movement := range input {
		direction := movement.direction
		value := movement.value
		switch direction {
		case "forward":
			horizontalPosition += value
			depth += aim * value
		case "down":
			aim += value
		case "up":
			aim -= value
		}
	}

	fmt.Println("Product of final depth and horizontal position with aim: ", depth*horizontalPosition)
}
