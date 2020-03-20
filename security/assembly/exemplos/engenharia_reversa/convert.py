#!python3

START = 0x5fa # Start of the factorial function according to gdb
END = 0x625   # End of the factorial function according to gdb

with open("exemplo.bin", "rb") as binary:
    byts = binary.read()[START:END]
    bin_str = lambda b: bin(b)[2:].rjust(8, "0")

    with open("bin.txt", "w", encoding="utf8") as bin_file:
        bin_file.write(" ".join([s for s in map(bin_str, byts)]))
