import random

def generuj_slovo(slovo):
    dvojice = [list(slovo[:-1] if len(slovo) % 2 == 1 else list(slovo))[x:x+2] for x in range(0, len(slovo) - 1 if len(slovo) % 2 == 1 else len(slovo), 2)]
    random.shuffle(dvojice)
    dvojice = "".join(["".join(dvojica) for dvojica in dvojice])

    if(len(slovo) % 2 == 1):
        dvojice = dvojice + slovo[-1]
    if not dvojice == slovo:
        return dvojice
    else:
        generuj_slovo(slovo)


nove_slovo = generuj_slovo("PYTAGORAS")
print(nove_slovo)
