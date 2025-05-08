#!/bin/bash

# Directory to read files from
DIR="."

# Output file
OUTPUT_FILE="context_gpt.txt"

# Clear the output file if it exists
> "$OUTPUT_FILE"

# Iterate over each file, skipping 'assets', 'node_modules', and 'package-lock.json'
find "$DIR" \( -type d -name 'assets' -o -type d -name 'node_modules' \) -prune -o -type f ! -name 'package-lock.json' -print | while read FILE; do
    echo "Processing $FILE"
    echo "====== Contents of $FILE ======" >> "$OUTPUT_FILE"
    cat "$FILE" >> "$OUTPUT_FILE"
    printf "\n\n" >> "$OUTPUT_FILE"
done

echo "All files have been processed. Check $OUTPUT_FILE for the output."
