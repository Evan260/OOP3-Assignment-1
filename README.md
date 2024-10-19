# Shape Sorting Application

This Java application reads shape data from a file and sorts the shapes based on various criteria such as volume, base area, or height using different sorting algorithms.

## Command-Line Arguments:

1. **File Path**: `-f "<filepath>"`  
   - Specifies the path of the file to load shapes from.  
   Example: `-f"res\shapes1.txt"`

2. **Comparison Type**: `-t <type>`  
   - `t`: Sort by **volume** (`-tv`)  
   - `a`: Sort by **base area** (`-ta`)  
   - `h`: Sort by **height** (`-th`)

3. **Sorting Algorithm**: `-s <sort>`  
   - `B`: Use **Bubble Sort** (`-sb`)  
   - `S`: Use **Selection Sort** (`-ss`)  
   - `I`: Use **Insertion Sort** (`-si`)  
   - `Q`: Use **Quick Sort** (`-sq`)
   - `M`: Use **Merge Sort** (`-sm`)
   - `H`: Use **Heap Sort** (`-sh`)

## List of Possible Commands:

### Sort By Volume (`-tv`):
- **Bubble Sort**: `java -jar Sort.jar -tv -sb -f"res\shapes1.txt"`
- **Selection Sort**: `java -jar Sort.jar -tv -ss -f"res\shapes1.txt"`
- **Insertion Sort**: `java -jar Sort.jar -tv -si -f"res\shapes1.txt"`
- **Quick Sort**: `java -jar Sort.jar -tv -sq -f"res\shapes1.txt"`
- **Quick Sort**: `java -jar Sort.jar -tv -sm -f"res\shapes1.txt"`
- **Quick Sort**: `java -jar Sort.jar -tv -sh -f"res\shapes1.txt"`

### Sort By Base Area (`-ta`):
- **Bubble Sort**: `java -jar Sort.jar -ta -sb -f"res\shapes1.txt"`
- **Selection Sort**: `java -jar Sort.jar -ta -ss -f"res\shapes1.txt"`
- **Insertion Sort**: `java -jar Sort.jar -ta -si -f"res\shapes1.txt"`
- **Quick Sort**: `java -jar Sort.jar -ta -sq -f"res\shapes1.txt"`
- **Insertion Sort**: `java -jar Sort.jar -ta -sm -f"res\shapes1.txt"`
- **Quick Sort**: `java -jar Sort.jar -ta -sh -f"res\shapes1.txt"`

### Sort By Height (`-th`):
- **Bubble Sort**: `java -jar Sort.jar -th -sb -f"res\shapes1.txt"`
- **Selection Sort**: `java -jar Sort.jar -th -ss -f"res\shapes1.txt"`
- **Insertion Sort**: `java -jar Sort.jar -th -si -f"res\shapes1.txt"`
- **Quick Sort**: `java -jar Sort.jar -th -sq -f"res\shapes1.txt"`
- **Insertion Sort**: `java -jar Sort.jar -th -sm -f"res\shapes1.txt"`
- **Quick Sort**: `java -jar Sort.jar -th -sh -f"res\shapes1.txt"`
- 
## Example Usage:
### Example 1:
To sort by **base area** using **Quick Sort** with the file `shapes1.txt` in the `res` folder:
```bash
java -jar Sort.jar -ta -sq -f"res\shapes1.txt"
```

### Example 2:
To sort by **volume** using **Selection Sort** with the file `shapes2.txt` in the `res` folder:
```bash
java -jar Sort.jar -tv -ss -f"res\shapes2.txt"
```

### Example 3:
To sort by **height** using **Bubble Sort** with the file `shapes3.txt` in the `res` folder:
```bash
java -jar Sort.jar -th -sb -f"res\shapes3.txt"
```

## Authors:
- [Evan Di Placido](https://github.com/Evan260)
- [Justin Nielsen](https://github.com/TortoiseGhos)
- [Savreet Singh](https://github.com/aulakh-savreet)
