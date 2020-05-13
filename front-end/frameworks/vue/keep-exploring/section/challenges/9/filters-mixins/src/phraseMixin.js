export default {
  computed: {
    commaPhrase() {
      return this.phrase.replace(/\s/g, ",");
    },
    sizePhrase() {
      return this.phrase
        .split("")
        .map((p) => `${p} (${p.length})`)
        .join("");
    },
  },
};
