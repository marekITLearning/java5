<template>
  <v-footer
    class="greyee justify-center"
    inset
    app
  >
    <span class="font-weight-light copyright">
      &copy;
      2021
      <a
        href="https://www.digitalsystems.eu"
        target="_blank"
        class="ds"
      >Digital Systems a.s.</a>
    </span>
  </v-footer>
</template>

<script>
export default {
  name: 'Footer'
}
</script>

<style scoped>
.ds {
  font-weight: 400;
  color: #248 !important;
  text-decoration: none;
}
</style>
