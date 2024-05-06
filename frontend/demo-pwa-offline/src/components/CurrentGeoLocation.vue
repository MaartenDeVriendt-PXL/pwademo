<template>
  <h1>Current Location</h1>
  <div id="map" class="map-container"></div>
</template>

<script>
import { ref, onMounted } from 'vue';
import 'ol/ol.css';
import Map from 'ol/Map';
import View from 'ol/View';
import TileLayer from 'ol/layer/Tile';
import OSM from 'ol/source/OSM';
import { useGeographic } from 'ol/proj';

export default {
  name: 'MapComponent',
  setup() {
    const map = ref(null);

    //zorgen dat de map met coordinaten werkt
    useGeographic();

    onMounted(() => {
      // Load map
      initMap();
    });

    const initMap = () => {
      map.value = new Map({
        target: 'map',
        layers: [
          new TileLayer({
            source: new OSM(),
          }),
        ],
        view: new View({
          center: [0, 0],
          zoom: 2,
        }),
      });

      // coordinaten van de gsm gebruiker nemen
      if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(
            (position) => {
              const coords = [position.coords.longitude, position.coords.latitude];
              map.value.getView().setCenter(coords);
              map.value.getView().setZoom(12);
            },
            (error) => {
              console.error('Geolocation error:', error.message);
              map.value.getView().setCenter([0, 0]);
              map.value.getView().setZoom(2);
            }
        );
      } else {
        console.error('Geolocation is not supported by this browser.');
        map.value.getView().setCenter([0, 0]);
        map.value.getView().setZoom(2);
      }
    };

    return { map };
  },
};
</script>

<style>
.map-container {
  margin-top: 30px;
  height: 400px;
  width: 100%;
}
</style>

