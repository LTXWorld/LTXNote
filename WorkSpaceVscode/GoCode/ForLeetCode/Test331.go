package main

import (
	"sort"
)

type Solution struct {
	targets map[string]map[string]int //
}

func NewSolution() *Solution {
	return &Solution{targets: make(map[string]map[string]int)}
}

func (s *Solution) FindItinerary(tickets [][]string) []string {
	for _, ticket := range tickets {
		if _, exists := s.targets[ticket[0]]; !exists {
			s.targets[ticket[0]] = make(map[string]int)
		}
		s.targets[ticket[0]][ticket[1]]++
	}

	path := []string{"JFK"}
	s.backtrack(len(tickets), &path)
	return path
}

// 回溯
func (s *Solution) backtrack(ticketNum int, path *[]string) bool {
	if len(*path) == ticketNum+1 {
		return true
	}

	last := (*path)[len(*path)-1]
	targetMap, exists := s.targets[last]
	if !exists {
		return false
	}
	//创建一个keys的切片存储map中的值，对其进行排序
	keys := make([]string, 0, len(targetMap))
	for key := range targetMap {
		keys = append(keys, key)
	}
	sort.Strings(keys)
	//进行结点的处理
	for _, key := range keys {
		count := targetMap[key]
		if count > 0 {
			*path = append(*path, key)
			targetMap[key]--
		}
		if s.backtrack(ticketNum, path) {
			return true
		}
		//回溯
		*path = (*path)[:len(*path)-1]
		targetMap[key]++
	}
	return false
}
