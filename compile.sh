#!/bin/bash

src_dir="src"
bin_dir="bin"
find "$src_dir" -name "*.java" > sources.txt
javac -d "$bin_dir" @sources.txt
rm sources.txt
