import re

RES = {"a": re.compile(r"á|à|ã|â"),
       "e": re.compile(r"é|ê"    ),
       "i": re.compile(r"í"      ),
       "o": re.compile(r"ó|õ|ô"  ),
       "c": re.compile(r"ç"      ),
       "A": re.compile(r"Á|À|Ã|Â"),
       "E": re.compile(r"É|Ê"    ),
       "I": re.compile(r"Í"      ),
       "O": re.compile(r"Ó|Õ|Ô"  ),
       "C": re.compile(r"Ç"      )}

PATHS = ["exercicios/ex{}/program.asm".format(n) for n in range(1, 7)] + ["exercicios/ex{}/solução.asm".format(n) for n in range(1, 7)]

for path in PATHS:
    print("Replacing '{}'".format(path))

    with open(path, "r", encoding="utf8") as file:
        updated = file.read()

        for c in RES: updated = RES[c].sub(c, updated)

    with open(path, "w", encoding="utf8") as file:
        file.write(updated)