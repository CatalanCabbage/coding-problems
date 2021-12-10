//Unsolved
//https://adventofcode.com/2021/day/4
package main

import (
	"fmt"
	"regexp"
	"strconv"
	"strings"
)

func runDay4() {
	fmt.Println("----------------Day 4----------------")
	inputStr := getSliceFromFile("day_4.txt")
	var boards [][5][5]string
	calledNumsStr := strings.Split(inputStr[0], ",")
	fmt.Println(calledNumsStr)
	spaceRegex := regexp.MustCompile("\\W{1,2}")
	//Start from bingo input
	for i := 2; i < len(inputStr); i++ {
		var board [5][5]string
		for j := 0; j < 5; j++ {
			boardLineStr := inputStr[i]                                                     //Complete line as a single string
			boardLineNumsAsStrings := spaceRegex.Split(strings.Trim(boardLineStr, " "), -1) //Split numbers as strings
			for k := 0; k < 5; k++ {
				board[j][k] = boardLineNumsAsStrings[k]
			}
			i++
		}
		//Add board
		boards = append(boards, board)
		//fmt.Println("board: ", board)
	}
	day4v1(calledNumsStr, boards)
	day4v2(inputStr)
	fmt.Println("-------------------------------------")
}

func day4v1(calledNums []string, boards [][5][5]string) {
	var completedBoard [5][5]string
	var lastCalledNumber int
	for _, calledNum := range calledNums {
		for _, board := range boards {
			//Strike that number from this board
			var isSolved = false
			if isSolved {
				lastCalledNumber, _ = strconv.Atoi(calledNum)
				completedBoard = board
				//break from both loops
			}
		}
	}
	//calculate score of completedBoard
}

func day4v2(inputStr []string) {

}
