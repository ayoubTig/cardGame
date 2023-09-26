<template>
  <div :class="['card bg-gray-lighter', card.color.toLowerCase()]" v-tippy="{ content: `Carte${card.valueVal }/${card.color }` , placement:'top' }">
    <div class="card-icon position-absolute top-0 end-0 pt-2"  >
      <span v-if="card.color === 'TREFLE'" class="mdi mdi-cards-club-outline"></span>
      <span v-else-if="card.color === 'COEUR'" class="mdi mdi-heart"></span>
      <span v-else-if="card.color === 'CARREAUX'" class="mdi mdi-cards-diamond"></span>
      <span v-else-if="card.color === 'PIQUE'" class="mdi mdi-cards-spade"></span>
    </div>
    <div class="card-value">{{ card.valueVal }}</div>
  </div>
</template>

<script>
export default {
  props: {
    card: {
      type: Object,
      required: true,
    },
  },
};
</script>

<style scoped>

.card {
  width: 100px;
  height: 150px;
  border: 1px solid #000;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  font-family: Arial, sans-serif;
  font-size: 16px;
  text-align: center;
  margin: 10px;
  border-radius: 6px;
  box-shadow: 0px 6px 9px rgba(0, 0, 0, 0.4);
  transition: transform 0.5s;
}

.card:hover {
  transform: scale(1.1);
  transition: transform 0.3s ease;
  transform: rotateY(40deg);
}

.card-icon {
  font-size: 36px; /* Adjust the size as needed */
}


.card-value {
  font-weight: bold;
  font-size: 21px;
}

.trefle {
  color: green;
}

.coeur {
  color: red;
}

.carreaux {
  color: blue;
}

.pique {
  color: black;
}
</style>
