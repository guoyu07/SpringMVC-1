  Vue.component('icon-svg',{
    template:'<svg class="svg-icon" aria-hidden="true"><use :xlink:href="iconName"></use></svg>',
    props: {
      iconClass: {
        type: String,
        required: true
      }
    },
    computed: {
      iconName: function(){
        return '#icon-' + this.iconClass;
      }
    }
  });