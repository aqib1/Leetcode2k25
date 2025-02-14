// using tail recursion and accumolators

// time complexity O(n) and space complexity O(n)
func fib(n int) int {
	return findFib(n, 0, 1)
}

func findFib(n int, a int, b int) int {
	if n == 0 {
		return a
	}

	if n == 1 {
		return b
	}

	return findFib(n-1, b, a+b)
}