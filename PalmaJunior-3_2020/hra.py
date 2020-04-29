def korytnacky_sa_nehnevaju(hody):
    zoznamHodov = hody.copy()
    pozicieHracov = [-1] * len(zoznamHodov)

    #kolo
    while True:
        for cisloHraca in range(len(zoznamHodov)):
            #normalne tahy
            if not pozicieHracov[cisloHraca] == -1:
                #ked padne 6, taha znova
                #
                #nekontrolujeme poziciu hraca: ked padne 6 a 3, hrac sa ma posunut o 9 okienok a teda
                #staci kontrolovat poziciu az pri poslednom tahu (kde uz na kocke nie je 6 a to riesi
                #kod nizsie)
                #
                #tiez ked na konci ostane hrac na rovnakej pozicii ako iny hrac, na kocke musela
                #padnut posledna 6, co nie je platny tah, kedze po 6 ma tahat este raz, co hrac neurobil
                #(zo zadania vieme, ze udaje o tahoch by mali byt platne)
                while zoznamHodov[cisloHraca][0] == 6:
                    pozicieHracov[cisloHraca] = pozicieHracov[cisloHraca] + zoznamHodov[cisloHraca][0]
                    del zoznamHodov[cisloHraca][0]

                novapozicia = pozicieHracov[cisloHraca] + zoznamHodov[cisloHraca][0]
                #ked je policko obsadene, hrac ide do domceka
                if novapozicia in pozicieHracov:
                    pozicieHracov[cisloHraca] = -1
                #ked nie, ide dalej
                else:
                    pozicieHracov[cisloHraca] = novapozicia
                del zoznamHodov[cisloHraca][0]

            #tah z domceka von
            else:
                if(zoznamHodov[cisloHraca][0] == 6):
                    pozicieHracov[cisloHraca] = 0
                del zoznamHodov[cisloHraca][0]

        #ked dosli tahy (pocitame ze su udaje spravne)
        if not zoznamHodov[0]:
            break

    return pozicieHracov

#hodnoty hodov kociek jednotlivych hracov
hody = [
[3, 4, 1, 6, 4, 2, 6, 2, 4, 2, 5, 1, 3, 4, 2],
[2, 6, 3, 1, 2, 6, 2, 4, 6, 1, 5, 3, 2, 4, 1, 2, 1]
]
vysledne_pozicie = korytnacky_sa_nehnevaju(hody)
print(vysledne_pozicie)
