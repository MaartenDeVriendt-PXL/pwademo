<template>
  <div v-if="info" class="card">
    <div class="card-header">
      <div class="card-subtitle">{{ info['post code'] }}</div>
      <div class="card-title">{{ info['places'][0]['place name'] }}</div>
      <div class="card-content">
        <div class="list">
          <div class="item">
            <div class="label">
              <strong>State:</strong> {{ info['places'][0]['state'] }} ({{ info['places'][0]['state abbreviation'] }} )
            </div>
          </div>
          <div class="item">
            <div class="label">
              <strong>Latitude:</strong> {{ info['places'][0]['latitude'] }}
            </div>
          </div>
          <div class="item">
            <div class="label">
              <strong>Longitude:</strong> {{ info['places'][0]['longitude'] }}
            </div>
          </div>
        </div>
      </div>
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
  background-color: #f9f9f9;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  margin: 20px;
  padding: 15px;
}

.card-header {
  padding-bottom: 10px;
  border-bottom: 1px solid #ddd;
}

.card-subtitle {
  font-size: 20px;
  color: #333;
}

.card-title {
  font-size: 24px;
  font-weight: bold;
  margin-top: 5px;
}

.card-content {
  padding-top: 15px;
}

.list {
  display: flex;
  flex-direction: column;
}

.item {
  margin-bottom: 10px;
}

.label {
  font-size: 18px;
}
</style>
