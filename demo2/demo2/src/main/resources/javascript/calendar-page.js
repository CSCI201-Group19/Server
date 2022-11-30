function updateDate() {
    const dateInput = document.querySelector('.date-picker');
    const monthValue = document.querySelector('#month');
    const currentDay = document.querySelector('#currentDay');
    const monthOptions = { month: "long" };
    let currentDayOptions = { weekday: 'long', month: 'long', day: 'numeric' };

    dateInput.valueAsDate = new Date();
    monthValue.textContent = new Intl.DateTimeFormat("en-US", monthOptions).format(dateInput.valueAsDate);
    currentDay.textContent = new Intl.DateTimeFormat("en-US", currentDayOptions).format(dateInput.valueAsDate);

    dateInput.addEventListener('change', (event) => {
        const monthValue = document.querySelector('#month');
        const currentDay = document.querySelector('#currentDay');
        // increment the date
        let date = event.target.valueAsDate;
        date.setDate(event.target.valueAsDate.getDate() + 1);

        // format the month variable and the current date variable
        monthValue.textContent = new Intl.DateTimeFormat("en-US", monthOptions).format(date);
        currentDay.textContent = new Intl.DateTimeFormat("en-US", currentDayOptions).format(date);

        // TODO: call the event list builder


    });
}