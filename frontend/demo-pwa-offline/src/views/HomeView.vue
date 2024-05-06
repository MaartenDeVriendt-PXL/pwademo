<template>
  <div>
    <h1>ZipInfo</h1>
    <div class="container">
      <ZipSearch v-on:get-zip="getZipInfo"/>
      <ZipInfo v-if="info" v-bind:info="info"/>
      <ClearInfo v-bind:info="info" v-on:clear-info="clearInfo"/>
    </div>
  </div>
</template>

<script>
import ZipSearch from '@/components/ZipSearch.vue';
import ZipInfo from '@/components/ZipInfo.vue';
import ClearInfo from '@/components/ClearInfo.vue';

export default {
  name: 'HomeView',
  components: {
    ZipSearch,
    ZipInfo,
    ClearInfo
  },
  data(){
    return{
      info: null
    }
  },
  methods: {
    async getZipInfo(zip){
      const response = await fetch(`https://api.zippopotam.us/be/${zip}`);
      if(response.status == 404){
        this.showAlert();
        return;
      }
      this.info = await response.json();
    },
    async showAlert() {
      alert('Please enter a valid Belgian zipcode');
    },
    clearInfo(){
      this.info = null;
    }
  }
}
</script>

<style scoped>
.container {
  padding: 20px;
}
</style>
