package main

import "fmt"

func Fibonacci(n int) {
    n1 := 0
    n2 := 1
    n3 := 0
    for i := 1; i <= n; i++ {
        fmt.Println(n1)
        n3 = n1 + n2
        n1 = n2
        n2 = n3
    }
}

func main() {
    Fibonacci(10)
}
