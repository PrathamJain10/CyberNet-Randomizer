## Project Overview

CyberNet-Randomizer is a Java-based utility that generates controlled random sequences of indices and values based on a predefined input rule set. It implements two distinct algorithms:

- **hop**: Starts at a random index within a specified range, traverses the list with controlled random ascending jumps, then performs fixed-size hops in reverse order to cover all remaining elements. ([github.com](https://github.com/PrathamJain10/CyberNet-Randomizer/blob/main/code/hop.java))
- **randomizers**: Begins at a random starting index, uses a randomized subset selection for ascending traversal, and applies fixed-size hops for any leftover indices. ([github.com](https://github.com/PrathamJain10/CyberNet-Randomizer/blob/main/code/randomizers.java))

Both algorithms read from `randomrule.txt` and output the visitation order to `output.txt` (which is initially empty). ([github.com](https://github.com/PrathamJain10/CyberNet-Randomizer/blob/main/code/randomrule.txt))

## Features

- **Configurable Starting Point**: Choose a random start within a given range (`hop` uses 1–100, `randomizers` uses 1–N). ([github.com](https://github.com/PrathamJain10/CyberNet-Randomizer/blob/main/code/hop.java)) ([github.com](https://github.com/PrathamJain10/CyberNet-Randomizer/blob/main/code/randomizers.java))
- **Controlled Random Ascension**: Limit the next index to within a maximum hop range for predictable randomness (`MAX_HOP_RANGE = 100`). ([github.com](https://github.com/PrathamJain10/CyberNet-Randomizer/blob/main/code/hop.java))
- **Fixed-Size Reverse Hops**: Guarantee full coverage by hopping a fixed number of steps (default 4) through remaining indices. ([github.com](https://github.com/PrathamJain10/CyberNet-Randomizer/blob/main/code/hop.java))
- **Simple File I/O**: Leverages Java NIO for reading input rules and standard IO for writing results. ([github.com](https://github.com/PrathamJain10/CyberNet-Randomizer/blob/main/code/hop.java))

## Prerequisites

- Java Development Kit (JDK) 8 or later installed. citehttps://www.oracle.com/java/technologies/javase-jdk11-downloads.html
- Command-line access to compile and run Java programs.

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/PrathamJain10/CyberNet-Randomizer.git
   ```
2. Navigate into the code directory:
   ```bash
   cd CyberNet-Randomizer/code
   ```
3. Ensure `randomrule.txt` is populated with your rule set (one value per line). ([github.com](https://github.com/PrathamJain10/CyberNet-Randomizer/blob/main/code/randomrule.txt))

## Usage

### Compile

```bash
javac hop.java randomizers.java
```

### Run `hop` Algorithm

```bash
java hop
``` 
- Reads from `randomrule.txt` and writes visitation order to `output.txt`. ([github.com](https://github.com/PrathamJain10/CyberNet-Randomizer/blob/main/code/hop.java))

### Run `randomizers` Algorithm

```bash
java randomizers
``` 
- Uses an alternate random subset strategy for ascension. ([github.com](https://github.com/PrathamJain10/CyberNet-Randomizer/blob/main/code/randomizers.java))

## Input Format

- **`randomrule.txt`**: A list of values (strings or codes), one per line. ([github.com](https://github.com/PrathamJain10/CyberNet-Randomizer/blob/main/code/randomrule.txt))

Example:
```
2c883ea6
45613715
b3b7abdc
...
```

## Output Format

- **`output.txt`**: Lines of the form `Index: i, Value: v`, representing the visitation sequence. Initially empty. ([github.com](https://github.com/PrathamJain10/CyberNet-Randomizer/blob/main/code/output.txt))

## Project Structure

```
CyberNet-Randomizer/
└── code/
    ├── hop.java           # Controlled-hop traversal implementation
    ├── randomizers.java   # Random-subset traversal implementation
    ├── randomrule.txt     # Input rule values
    └── output.txt         # Generated visitation output
```([github.com](https://github.com/PrathamJain10/CyberNet-Randomizer/tree/main/code))

## Customization

- **HOP_VALUE**: Modify `HOP_VALUE` constant in both classes to change reverse-hop size. ([github.com](https://github.com/PrathamJain10/CyberNet-Randomizer/blob/main/code/hop.java))
- **MAX_HOP_RANGE**: Adjust in `hop.java` to alter ascending-range limit. ([github.com](https://github.com/PrathamJain10/CyberNet-Randomizer/blob/main/code/hop.java))
- **Starting Range**: Change the parameters of `getRandomStartingIndex()` for different start distributions. ([github.com](https://github.com/PrathamJain10/CyberNet-Randomizer/blob/main/code/randomizers.java))

## Contributing

Contributions are welcome! Please fork the repo, create a feature branch, and submit a pull request with tests and documentation.

## License

This project is released under the MIT License. See `LICENSE` for details.
