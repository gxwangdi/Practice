package main

import (
	"fmt"
	"log"
	"os"
	"path/filepath"
	"strings"
)

/**
 * Use case:
 * $go build auto.go
 * $./auto 61-Rotate-List
 * If dir 61-Rotate-List does not exist, it will be created.
 * And RotateList.[postfix] and *.md will be added if not available.
 */
func main() {
	dir, err := filepath.Abs(filepath.Dir(os.Args[0]))
	if err != nil {
		log.Fatal(err)
	}
	fmt.Println(dir)
	sep := string(os.PathSeparator)
	fmt.Println(sep)

	args := os.Args[1:]
	fmt.Println(args)
	pn := args[0]
	n := pn[strings.Index(pn, "-")+1:]
	fmt.Println(n)
	fn := strings.Replace(n, "-", "", -1)
	// strings.ReplaceAll() supported in 1.12.
	path := dir + sep + pn
	if _, err := os.Stat(path); os.IsNotExist(err) {
		os.Mkdir(path, os.ModeDir|os.ModePerm)
	}
	var files [8]string
	files[0] = path + sep + "README.md"
	files[1] = path + sep + "Question.md"
	files[2] = path + sep + fn + ".java"
	files[3] = path + sep + fn + ".cpp"
	files[4] = path + sep + fn + ".js"
	files[5] = path + sep + fn + ".py"
	files[6] = path + sep + fn + "_3.py"
	files[7] = path + sep + fn + ".go"
	fmt.Println(files)
	for _, file := range files {
		if _, err := os.Stat(file); !os.IsNotExist(err) {
			continue
		}
		f, e := os.Create(file)
		if e != nil {
			fmt.Println(e)
			continue
		} else {
			fmt.Println(file)
		}
		defer f.Close()
	}
}
