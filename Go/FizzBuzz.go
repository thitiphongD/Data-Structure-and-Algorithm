package main

import "fmt"

func Fibonacci(n int) {
    i := 0
    for i <= n {
        if (i % 3 == 0 && i % 5 == 0) {
            fmt.Println(i, "FizzBuzz")
            i++
        } else if i % 3 == 0 {
            fmt.Println(i, "Fizz")
            i++
        } else if i % 5 == 0 {
            fmt.Println(i, "Buzz")
            i++
        } else {
            fmt.Println(i)
            i++
        }
    }
}

func main() {
    Fibonacci(15)
}
