<template>
  <div>
    <form @submit.prevent="onSubmit">
      <label for="zip">ZipCode:</label>
      <input type="text" v-model="zip" placeholder="Enter Zipcode" name="zip" id="zip">
      <button type="submit" class="button">Find</button>
    </form>
  </div>
</template>

<script>
export default {
  name: "ZipSearch",
  data() {
    return {
      zip: ""
    };
  },
  methods: {
    onSubmit() {
      const isValidZip = /(^\d{4}$)|(^\d{4}-\d{3}$)/.test(this.zip);
      if (!isValidZip) {
        this.showAlert();
        this.zip = '';
      } else {
        this.$emit("get-zip", this.zip);
        this.zip = '';
      }
    },
    async showAlert() {
      alert('Please enter a valid Belgian zipcode.');
    }
  }
};
</script>

<style scoped>
.button {
  width: 100%; /* Make button take the full width */
  margin-top: 30px;
  background-image: linear-gradient(to bottom right, #4e9af1, #2f76e4);
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
