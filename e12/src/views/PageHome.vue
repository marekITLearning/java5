<template>
  <q-page padding>
    <big-title></big-title>
  </q-page>
</template>

<script>
import { QPage } from 'quasar'
import BigTitle from '@/components/PageHome/BigTitle'

export default {
  name: 'PageHome',

  components: {
    QPage,
    BigTitle
  }
}
</script>
