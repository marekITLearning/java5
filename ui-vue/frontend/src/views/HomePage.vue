<template>
  <section @update-customers="loadData">
    <my-form />
    <my-table :customers="customers" />
  </section>
</template>

<script>
import MyForm from '@/components/HomePage/MyForm'
import MyTable from '@/components/HomePage/MyTable'
export default {
  name: 'HomePage',

  components: {
    MyForm,
    MyTable
  },

  data () {
    return {
      customers: []
    }
  },

  methods: {
    loadData () {
      console.log('load')
      this.$api
        .get('/customer')
        .then(response => {
          this.customers = response.body
        })
    }
  },

  created () {
    this.loadData()
  }
}
</script>
