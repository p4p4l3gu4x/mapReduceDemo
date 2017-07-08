function(name, counters) {
    count = 0;

    for (var index = 0; index < counters.length; ++index) {
        count += counters[index];
    }

    return count;
}