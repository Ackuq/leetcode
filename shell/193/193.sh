file_content=$(cat ./file.txt)

REGEX_1="^\([0-9]{3}\) [0-9]{3}-[0-9]{4}$"
REGEX_2="^[0-9]{3}-[0-9]{3}-[0-9]{4}$"

while read -r line; do
  if [[ $line =~ $REGEX_1  || $line =~ $REGEX_2 ]]; then
    echo $line
  fi
done <<< "$file_content"
