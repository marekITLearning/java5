<template>
  <div>
    <v-dialog
      v-bind="$attrs"
      persistent
      :max-width="maxWidth"
    >
      <v-card>
        <v-card-title class="headline">
          <v-row>
            <v-col
              cols="12"
              sm="4"
            >
              <a
                target="_blank"
                :href="getLinkFromItem(slug)"
              >
                {{ exchangeRating.exName }}</a>
            </v-col>
            <v-col
              v-if="exchangeRating.data != null"
              cols="6"
              sm="4"
            >
              <p :class="getRiskColor(exchangeRating.data.risk)">
                {{ getRiskName(exchangeRating.data.risk) }}
              </p>
            </v-col>
            <v-col
              v-if="exchangeRating.data != null"
              cols="6"
              sm="4"
            >
              Rating: {{ exchangeRating.data.rating }}
            </v-col>
          </v-row>
          <v-progress-linear
            color="blue accent-4"
            :active="loading"
            :indeterminate="loading"
            rounded
            height="6"
          />
          <v-btn
            absolute
            icon
            rounded
            style="top: 0px; right: 0px"
            class="ma-3 error--text"
            @click="$emit('close-dialog')"
          >
            <v-icon size="xx-large">
              mdi-close-circle-outline
            </v-icon>
          </v-btn>
        </v-card-title>

        <slot />

        <slot name="content" />

        <v-card-actions>
          <v-spacer />
          <v-btn
            v-if="saveButton"
            :color="saveButtonColor"
            class="ma-0 pa-0"
            text
            :loading="loading"
            @click="saveDialog"
          >
            {{ $i18n.t(saveButtonLabel) }}
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </div>
</template>

<script>
export default {
  name: 'Dialog',
  props: {
    exchangeRating: {
      type: Object,
      default: null
    },
    saveButton: {
      type: Boolean,
      required: false
    },
    saveButtonLabel: {
      type: String,
      default: 'App.save'
    },
    saveButtonColor: {
      type: String,
      default: 'info'
    },
    maxWidth: {
      type: String,
      required: false,
      default: '600'
    },
    loading: {
      type: Boolean,
      default: false
    },
    slug: {
      type: String,
      required: true
    }
  },
  methods: {
    saveDialog () {
      this.$emit('save-dialog')
    },
    getRiskName (val) {
      if (val === 2) {
        return 'LOW'
      } else if (val === 1) {
        return 'MEDIUM'
      } else {
        return 'HIGH'
      }
    },
    getRiskColor (val) {
      if (val === 2) {
        return 'green--text'
      } else if (val === 1) {
        return 'orange--text'
      } else {
        return 'red--text'
      }
    },
    getLinkFromItem (slug) {
      return 'https://coinmarketcap.com/exchanges/' + slug + '/'
    }
  }
}
</script>
