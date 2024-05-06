<template>
    <div v-if="info" class="card">
      <div class="card-header">
        <div class="card-subtitle">
          {{ info['post code'] }}
        </div>
        <div class="card-title">
          {{ info['places'][0]['place name'] }}
        </div>
        <ion-card-content>
            <ion-list>
                <ion-item>
                    <ion-label>
                        <strong>State:</strong>
                        {{info['places'][0]['state']}} ({{info['places'][0]['state abbreviation']}} )
                    </ion-label>
                </ion-item>
                <ion-item>
                    <ion-label>
                        <strong>Latitude:</strong>
                        {{info['places'][0]['latitude']}}
                    </ion-label>
                </ion-item>
                <ion-item>
                    <ion-label>
                        <strong>Longitude:</strong>
                        {{info['places'][0]['longitude']}}
                    </ion-label>
                </ion-item>
            </ion-list>
        </ion-card-content>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    name: "ZipInfo",
    props: ["info"],
  };
  </script>
  
  <style scoped>
  .card {
    background-color: #fff;
    border-radius: 6px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    margin: 20px;
  }
  
  .card-header {
    padding: 20px;
  }
  
  .card-subtitle {
    font-size: 14px;
    color: #888;
  }
  
  .card-title {
    font-size: 18px;
    font-weight: bold;
    margin-top: 5px;
  }
  </style>
  