private void calculateDiscount() {
    String originalPriceStr = originalPriceEditText.getText().toString();
    String discountPercentageStr = discountPercentageEditText.getText().toString();

    if (originalPriceStr.isEmpty() || discountPercentageStr.isEmpty()) {
        Toast.makeText(this, "Please enter valid values.", Toast.LENGTH_SHORT).show();
        return;
    }

    double originalPrice = Double.parseDouble(originalPriceStr);
    double discountPercentage = Double.parseDouble(discountPercentageStr);

    // Validate original price and discount percentage
    if (originalPrice <= 0) {
        resultTextView.setText("Invalid input: Original price cannot be 0 or negative.");
        return;
    }

    if (discountPercentage < 0 || discountPercentage > 100) {
        resultTextView.setText("Invalid input: Discount percentage must be between 0 and 100.");
        return;
    }

    // Calculate discount amount
    double discountAmount = originalPrice * (discountPercentage / 100);

    // Check if discount amount exceeds original price
    if (discountAmount > originalPrice) {
        resultTextView.setText("Invalid input: Discount cannot exceed the original price.");
        return;
    }

    double finalPrice = originalPrice - discountAmount;

    resultTextView.setText(String.format("Discount Amount: %.2f Tk\nFinal Price: %.2f Tk", discountAmount, finalPrice));
}
