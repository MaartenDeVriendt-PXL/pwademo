<template>
  <button v-if="info" class="button" @click="$emit('clear-info')">
    Clear
  </button>
</template>

<script>
export default {
  name: "ClearInfo",
  props: ["info"],
};
</script>

<style scoped>
.button {
  width: 100%;
  margin-top: 30px;
  background-image: linear-gradient(to bottom right, gray, darkgray);
  color: #fff;
  border: none;
  padding: 10px 20px;
  font-size: 16px;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.button:hover {
  background-color: #2f76e4;
}
</style>
