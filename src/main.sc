require: slotfilling/slotFilling.sc
  module = sys.zb-common
require: functions.js
theme: /

    state: Start
        q!: $regex</start>
        a: Молви друг и войди!
        
        state: notmelon
            q: друг
            a: На эльфийском, друг!
        
        state: Melon
            q: * (melon|~мелон) *
            a: Входите! Вы вошли в подземелье Мории. Перед вами три коридора.
               Ваши действия?
            
            state: Left
                q:* *лев* *
                a: Вас съел дракон.
                go!: /Start
                
            state: Right
                q:* *прав* *
                a: Перед вами сундук. Ваши действия?
                a: Вы видите сундук.
                    
                state: open
                    q: открыть
                    a: В сундуке оказались монеты, ровно {{getRandomInt(10) }}
                    
            state: Staight
                q:* *прям* *
                a: Вы долго бредете по темному коридору и упираетесь в тупик.
                        
            state: Back
                q:* (назад|~вернуться|~вернуть|~возвращаться) *
                a: Вход завалило. Выберите другое направление.
                            
                state: NoMatchWay
                    event: noMatch
                    # a: Выберите направление
                    go!:: /Start/Melon/Left
        
    state: NoMatch
        event!: noMatch
        a: Попробуйте сказать это на эльфийском.