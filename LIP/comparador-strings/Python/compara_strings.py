import re

def reverse(text):
    if len(text) <= 1:
        return text

    return reverse(text[1:]) + text[0]

string_um = input()
string_dois = input()

print(string_um, ": ", len(string_um))
print(string_dois, ": ", len(string_dois))

if re.search(string_dois, string_um, re.IGNORECASE):
    print(string_um,"contem", string_dois)
else:
    print(string_um,"nao contem", string_dois)

if re.search(string_um, string_dois, re.IGNORECASE):
    print(string_dois,"contem", string_um)
else:
    print(string_dois, "nao contem", string_um)

print(reverse(string_um))
print(reverse(string_dois))
    