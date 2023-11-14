file_content=$(cat "./words.txt")
echo $file_content | tr -s " " "\n" | sort | uniq -c | sort -r | awk '{print $2" "$1}'
