var Moves = []int{-1, 0, 1, 0, -1}

func hasPath(maze [][]int, start []int, destination []int) bool {
    var visited = make([][]bool, len(maze))
	for i := range visited {
		visited[i] = make([]bool, len(maze[0]))
	}

	return hasPathRecur(maze, visited, start, destination)
}

func hasPathRecur(maze [][]int, visited [][]bool, start []int, destination []int) bool {
	if visited[start[0]][start[1]] {
		return false
	}
	if start[0] == destination[0] && start[1] == destination[1] {
		return true
	}
	visited[start[0]][start[1]] = true
	for move := 0; move < len(Moves)-1; move++ {
		var x = start[0]
		var y = start[1]

		for x >= 0 && x < len(maze) && y >= 0 && y < len(maze[0]) && maze[x][y] == 0 {
			x += Moves[move]
			y += Moves[move+1]
		}

		if hasPathRecur(maze, visited, []int{x - Moves[move], y - Moves[move+1]}, destination) {
			return true
		}
	}

	return false
}
