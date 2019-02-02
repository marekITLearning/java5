<template functional>
  <v-content>
    <v-container fluid fill-height>

      <!-- Animated transition between pages -->
      <v-fade-transition mode="out-in" appear>
        <router-view />
      </v-fade-transition>

    </v-container>
  </v-content>
</template>
