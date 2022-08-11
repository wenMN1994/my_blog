module.exports = {
  // some nuxt config...
  vender:[
    'element-ui', 'axios'
  ],
  css: [
    'element-ui/lib/theme-chalk/index.css',
    '~node_modules/swiper/swiper-bundle.css'
  ],

  plugins: [
    { src: '~/plugins/nuxt-plugin', ssr: false},
    { src: '~/plugins/element-ui', ssr: true },
  ],
  
  /*
	 ** Headers of the page
	 */
  head: {
    title: '龙颜科技',
    meta: [{
      charset: 'utf-8'
    },
    {
      name: 'viewport',
      content: 'width=device-width, initial-scale=1'
    },
    {
      hid: 'keywords',
      name: 'keywords',
      content: '龙颜科技'
    },
    {
      hid: 'description',
      name: 'description',
      content: '龙颜科技'
    }
    ],
    link: [{
      rel: 'icon',
      type: 'image/x-icon',
      href: '/favicon.ico'
    }]
  },

  /*
	 ** Customize the progress bar color
	 */
  loading: {
    color: '#3B8070'
  },
  /*
	 ** Build configuration
	 */
  build: {
    /*
		 ** Run ESLint on save
		 */
    extend(config, {
      isDev,
      isClient
    }) {
      if (isDev && isClient) {
        config.module.rules.push({
          enforce: 'pre',
          test: /\.(js|vue)$/,
          loader: 'eslint-loader',
          exclude: /(node_modules)/
        })
      }
    }
  }
}
