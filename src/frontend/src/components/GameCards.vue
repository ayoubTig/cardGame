<template>
  <div class="container mx-auto my-3 card-body">

      <transition-group  name="x" tag="div" class="flexbox">
        <span v-for="card in handCards" :key="card.id">
          <Card :card="card" />
        </span>
      </transition-group>

      <div class="text-center my-3" >

        <button class="btn btn-round btn-custom col" @click="getHandCards()" :disabled="disabledBtn">
          <span>Re-distribuer à nouveau les cartes<i class="mdi mdi-cards-playing-outline "/> </span>
        </button>
        
        <button class="btn btn-round btn-custom col" @click="sortCards()" :disabled="disabledBtn" v-show="!cardsIsSorted">
          <span>Trier les cartes<i class="mdi mdi-sort-alphabetical-ascending "/> </span>
        </button>
      </div>

    <transition-group  name="y" tag="div" class="flexbox" v-if="cardsIsSorted">
      <span v-for="cardSorted in sortedCards" :key="cardSorted.id">
        <Card :card="cardSorted" />
      </span>
    </transition-group>

  </div>
</template>

<script>
import Card from './gameCards/Card.vue';
export default {
  name:"game",

  components:{
    Card
  },

  data(){
    return {
      handCards:{},
      error:false,
      username:"player",
      userPassword: "player",
      sortedCards:{},
      cardsIsSorted:false,
      disabledBtn:false

    }
  },
  created(){
    this.getHandCards();
  },

  methods: {
    getHandCards(){
        this.cardsIsSorted = false;
        this.disabledBtn = true;
        const requestOptions = {
          method: 'GET',
          headers: { 'Content-Type': 'application/json' }
        };
        fetch("/api/game/hand-cards/"+this.username+"/"+this.userPassword,requestOptions).then(async (response ) => {
            if (response.ok) {
              this.handCards = await response.json();
              this.error = false
              this.disabledBtn = false;
            } else {
              this.error = true
            }
        });
    },
    sortCards(){
      this.cardsIsSorted = true;
      this.disabledBtn = true;
      const requestOptions = {
          method: 'POST',
          headers: { 'Content-Type': 'application/json' },
          body: JSON.stringify(this.handCards)
        };

        fetch("/api/game/sort-hand-cards",requestOptions).then(async (response ) => {
          console.log("response ==> ", response.text);
            if (response.ok) {
              this.sortedCards = await response.json();
              this.error = false;
              this.disabledBtn = false;
            } else {
              this.error = true
            }
        });
      }
    
  },

}
</script>

<style >

.x-enter-active, .x-leave-active {
  transition: transform 1s;
}

.x-enter, .x-leave-to {
  transform: translateX(100px);
}

.y-enter-active, .y-leave-active {
  transition: transform 1.5s;
}

.y-enter, .y-leave-to {
  transform: translateY(100px);
}


</style>
