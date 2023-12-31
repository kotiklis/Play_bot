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
            q:* (melon|~мелон) *
            a: Входите! Вы вошли в подземелье Мории. Перед вами три коридора.
               Ваши действия?
            
            state: Left
                q:* *лев* *
                a: Вас съел дракон. 
                a: Повторить попытку?
                
                state: yes
                    q: да
                    go!: /Start
                    
                state: no
                    q: нет
                    a: Прощай, друг!
                
            state: Right
                q:* *прав* *
                a: Перед вами сундук. Ваши действия?
                a: Вы видите сундук.
                    
                state: open
                    q:* *откр* *
                    a: В сундуке оказались монеты, ровно {{getRandomInt(10) }}
                    
                    state: goblin
                        q:* *забр* * 
                        a: Перед тобой выход из подземелья, однако его преграждает Гоблин. 
                        a: Поговорить с ним?
                        
                        state: yes
                            q: да
                            a: Я пропущу тебя только за 7 монет.
                            a: У тебя их $number .
                            
                        state: no
                            q: нет
                            a: Вы проиграли, другого выхода из подземелья нет.
                    
            state: Staight
                q:* *прям* *
                a: Вы долго бредете по темному коридору и упираетесь в тупик. 
                a: Куда дальше?
                        
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