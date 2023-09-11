require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Молви друг и войди!
        
        state: Melon
            q: melon
            a: Входите! Вы вошли в подземелье Мории. Перед вами три коридора.
               Ваши действия?
            
            state: Left
                q: * *лев* *
                a: Вас съел дракон.
        
    state: NoMatch
        event!: noMatch
        a: Попробуйте сказать это на эльфийском.