// Navbar transparency control
const navbar = document.getElementById('mainNavbar');
const homeSection = document.getElementById('home');

// Function to check if element is in viewport
function isInViewport(element) {
    const rect = element.getBoundingClientRect();
    return (
        rect.top <= 100 &&
        rect.bottom >= 0
    );
}

// Scroll event listener
window.addEventListener('scroll', function() {
    // Check if we're at the top of the page
    if (window.scrollY < 50) {
        navbar.classList.add('navbar-home');
        navbar.classList.remove('scrolled');
    } else {
        navbar.classList.remove('navbar-home');
        navbar.classList.add('scrolled');
    }
});

// Click event listener for nav links
document.querySelectorAll('.nav-link').forEach(link => {
    link.addEventListener('click', function() {
        if (this.getAttribute('href') !== '#home') {
            navbar.classList.remove('navbar-home');
            navbar.classList.add('scrolled');
        } else {
            // Special handling for home link
            setTimeout(() => {
                if (window.scrollY < 50) {
                    navbar.classList.add('navbar-home');
                    navbar.classList.remove('scrolled');
                }
            }, 100);
        }
    });
});

// Easing function: easeInOutQuad
function easeInOutQuad(t, b, c, d) {
    t /= d / 2;
    if (t < 1) return c / 2 * t * t + b;
    t--;
    return -c / 2 * (t * (t - 2) - 1) + b;
}

// Smooth scrolling with easing
document.querySelectorAll('.nav-link').forEach(anchor => {
    anchor.addEventListener('click', function (e) {
        e.preventDefault();
        const targetId = this.getAttribute('href');
        const targetElement = document.querySelector(targetId);
        const start = window.pageYOffset;
        
        // Adjust target position for fixed navbar
        let targetPos;
        if (targetId === '#home') {
            targetPos = 0;
        } else {
            targetPos = targetElement.getBoundingClientRect().top + window.pageYOffset - 80;
        }
        
        const distance = targetPos - start;
        const duration = 1000;
        let startTime = null;

        function animateScroll(currentTime) {
            if (!startTime) startTime = currentTime;
            const timeElapsed = currentTime - startTime;
            const run = easeInOutQuad(timeElapsed, start, distance, duration);
            window.scrollTo(0, run);
            if (timeElapsed < duration) requestAnimationFrame(animateScroll);
        }

        requestAnimationFrame(animateScroll);
    });
});

// Trigger animations on scroll
const animateElements = document.querySelectorAll('.animate-slideUp');
const observer = new IntersectionObserver(entries => {
    entries.forEach(entry => {
        if (entry.isIntersecting) {
            entry.target.style.animationPlayState = 'running';
        }
    });
}, { threshold: 0.2 });
animateElements.forEach(el => observer.observe(el));