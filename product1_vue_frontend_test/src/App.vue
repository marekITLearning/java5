<template>
  <q-layout>

    <q-btn-group outline>
      <q-btn outline color="brown" label="Home" @click="routeToHome()"/>
      <q-btn outline color="brown" label="About" icon-right="watch_later" @click="routeToAbout()"/>
    </q-btn-group>
  
    <q-page-container>
      <q-page>
        <router-view />
      </q-page>
    </q-page-container>
  </q-layout>

</template>

<script setup>

const routeToHome = function() {}
const routeToAbout = function() {}



</script>