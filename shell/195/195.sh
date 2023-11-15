file_content=$(cat "./file.txt")

i=0
while read -r line; do
  if [[ i -ge 9 ]]; then
    echo $line
    break
  fi
  i=$((i+1))
done <<< "$file_content"
