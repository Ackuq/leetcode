awk '
  {
    for (column = 1; column <= NF; column++) {
      a[NR, column] = $column
    } 
  }
  NF > nf { nf = NF }
  END {
    for (column = 1; column <= nf; column++) {
      for(row = 1; row <= NR; row++) {
        printf a[row, column] (row==NR ? RS : FS)
      }
    }
  }
  ' ./file.txt