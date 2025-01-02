class OptimalSolution:
    def encode(self, strs):
        """Encodes a list of strings to a single string.
        """
        return ''.join(f'{len(s)}#{s}' for s in strs)

    def decode(self, s):
        """Decodes a single string to a list of strings.
        """
        i, n = 0, len(s)
        result = []
        while i < n:
            j = s.find('#', i)
            length = int(s[i:j])
            i = j + 1 + length
            result.append(s[j + 1:i])
        return result

# Example usage:
codec = OptimalSolution()
encoded = codec.encode(["hello", "world"])
print("Encoded:", encoded)
decoded = codec.decode(encoded)
print("Decoded:", decoded)