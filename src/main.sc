require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Молви друг и войди!

    state: NoMatch
        event!: noMatch
        a: Попробуйте сказать это на эльфийском.