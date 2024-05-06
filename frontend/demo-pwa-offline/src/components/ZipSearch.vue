<template>
    <ion-grid>
        <form @submit="onSubmit">
            <ion-col>
                <ion-item>
                    <ion-label>ZipCode:</ion-label>
                    <ion-input :value="zip" @input="zip = $event.target.value" placeholder="Enter Zipcode" name="zip"></ion-input>
                </ion-item>
            </ion-col>
            <ion-col>
                <ion-button type="submit" color="primary" expand="block">Find</ion-button>
            </ion-col>
        </form>
    </ion-grid>
</template>

<script>

import { alertController } from '@ionic/vue';

export default {
    name: "ZipSearch",
    data(){
        return{
            zip: ""
        }
    },
    methods:{
        onSubmit(event){
            event.preventDefault();
            //const isValidZip = /(^\d{5}$)|(^\d{5}-\d{4}$)/.test(this.zip);
            const isValidZip = /(^\d{4}$)|(^\d{4}-\d{3}$)/.test(this.zip);
            //console.log(isValidZip);
            if(!isValidZip){
                this.showAlert();
                this.zip = '';
            }else{
                this.$emit("get-zip", this.zip);
                this.zip = '';
            }
        },
        async showAlert() {
            const alert = await alertController.create({
                header: 'Enter Zipcode',
                message: 'Please enter a valid Belgian zipcode',
                buttons: ['OK']
            });

      await alert.present();
    }
    }
}
</script>

<style>

</style>
