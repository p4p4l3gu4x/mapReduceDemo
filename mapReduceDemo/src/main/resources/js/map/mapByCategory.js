function() {
    for (var index = 0; index < this.categories.length; ++index) {
        var category = this.categories[ index ];
        emit( category, 1 );
    }
}